<template>
  <p>
    <a-space>
      <a-date-picker v-model:value="params.date" valueFormat="YYYY-MM-DD" placeholder="请选择日期"/>
      <train-select-view v-model:value="params.trainCode" width="200px"></train-select-view>
      <a-button type="primary" @click="handleQuery()">查询</a-button>
      <a-button type="primary" @click="onAdd">新增</a-button>
    </a-space>
  </p>
  <a-table :dataSource="dailyTrainStations"
           :columns="columns"
           :pagination="pagination"
           @change="handleTableChange"
           :loading="loading">
    <template #bodyCell="{ column, record }">
      <template v-if="column.dataIndex === 'action'">
        <a-space>
          <a-popconfirm
              title="删除后不可恢复，确认删除?"
              @confirm="onDelete(record)"
              ok-text="确认" cancel-text="取消">
            <a style="color: red">删除</a>
          </a-popconfirm>
          <a @click="onEdit(record)">编辑</a>
        </a-space>
      </template>
    </template>
  </a-table>
  <a-modal v-model:open="visible" title="每日车站" @ok="handleOk"
           ok-text="确认" cancel-text="取消">
    <a-form :model="dailyTrainStation" :label-col="{span: 4}" :wrapper-col="{ span: 20 }">
      <a-form-item label="日期">
        <a-date-picker v-model:value="dailyTrainStation.date" valueFormat="YYYY-MM-DD" placeholder="请选择日期"/>
      </a-form-item>
      <a-form-item label="车次编号">
        <train-select-view v-model:value="dailyTrainStation.trainCode"></train-select-view>
      </a-form-item>
      <a-form-item label="站序">
        <a-input v-model:value="dailyTrainStation.index"/>
      </a-form-item>
      <a-form-item label="站名">
        <a-input v-model:value="dailyTrainStation.name"/>
      </a-form-item>
      <a-form-item label="站名拼音">
        <a-input v-model:value="dailyTrainStation.namePinyin" disabled/>
      </a-form-item>
      <a-form-item label="进站时间">
        <a-time-picker v-model:value="dailyTrainStation.entryTime" valueFormat="HH:mm:ss" placeholder="请选择时间"/>
      </a-form-item>
      <a-form-item label="出站时间">
        <a-time-picker v-model:value="dailyTrainStation.exitTime" valueFormat="HH:mm:ss" placeholder="请选择时间"/>
      </a-form-item>
      <a-form-item label="停站时长">
        <a-time-picker v-model:value="dailyTrainStation.stopTime" valueFormat="HH:mm:ss" placeholder="请选择时间" disabled/>
      </a-form-item>
      <a-form-item label="里程（公里）">
        <a-input v-model:value="dailyTrainStation.km"/>
      </a-form-item>
    </a-form>
  </a-modal>
</template>

<script>
import {defineComponent, ref, onMounted, watch} from 'vue';
import {notification} from "ant-design-vue";
import axios from "axios";
import TrainSelectView from "@/components/train-select.vue";
import {pinyin} from "pinyin-pro";
import dayjs from "dayjs";

export default defineComponent({
  name: "daily-train-station-view",
  components: {TrainSelectView},
  setup() {
    const visible = ref(false);
    let dailyTrainStation = ref({
      id: undefined,
      date: undefined,
      trainCode: undefined,
      index: undefined,
      name: undefined,
      namePinyin: undefined,
      entryTime: undefined,
      exitTime: undefined,
      stopTime: undefined,
      km: undefined,
      createTime: undefined,
      updateTime: undefined,
    });
    const dailyTrainStations = ref([]);
    // 分页的三个属性名是固定的
    const pagination = ref({
      total: 0,
      current: 1,
      pageSize: 10,
    });
    let loading = ref(false);
    let params = ref({
      date: null,
      trainCode: null
    })
    const columns = [
      {
        title: '日期',
        dataIndex: 'date',
        key: 'date',
      },
      {
        title: '车次编号',
        dataIndex: 'trainCode',
        key: 'trainCode',
      },
      {
        title: '站序',
        dataIndex: 'index',
        key: 'index',
      },
      {
        title: '站名',
        dataIndex: 'name',
        key: 'name',
      },
      {
        title: '站名拼音',
        dataIndex: 'namePinyin',
        key: 'namePinyin',
      },
      {
        title: '进站时间',
        dataIndex: 'entryTime',
        key: 'entryTime',
      },
      {
        title: '出站时间',
        dataIndex: 'exitTime',
        key: 'exitTime',
      },
      {
        title: '停站时长',
        dataIndex: 'stopTime',
        key: 'stopTime',
      },
      {
        title: '里程（公里）',
        dataIndex: 'km',
        key: 'km',
      },
      {
        title: '操作',
        dataIndex: 'action'
      }
    ];

    watch(() => dailyTrainStation.value.name, () => {
      if (Tool.isNotEmpty(dailyTrainStation.value.name)) {
        dailyTrainStation.value.namePinyin = pinyin(dailyTrainStation.value.name, {toneType: 'none'}).replace(" ", "");
      } else {
        dailyTrainStation.value.namePinyin = "";
      }
    }, {immediate: true});

    // 自动计算停站时长
    watch (() => dailyTrainStation.value.entryTime, () => {
      let diff = dayjs(dailyTrainStation.value.exitTime, "HH:mm:ss").diff(dayjs(dailyTrainStation.value.entryTime, "HH:mm:ss"), "second");
      dailyTrainStation.value.stopTime = dayjs("00:00:00", "HH:mm:ss").second(diff).format("HH:mm:ss");
    }, {immediate: true});

    // 自动计算停站时长
    watch (() => dailyTrainStation.value.exitTime, () => {
      let diff = dayjs(dailyTrainStation.value.exitTime, "HH:mm:ss").diff(dayjs(dailyTrainStation.value.entryTime, "HH:mm:ss"), "second");
      dailyTrainStation.value.stopTime = dayjs("00:00:00", "HH:mm:ss").second(diff).format("HH:mm:ss");
    }, {immediate: true});

    const onAdd = () => {
      dailyTrainStation.value = {};
      visible.value = true;
    };

    const onEdit = (record) => {
      dailyTrainStation.value = window.Tool.copy(record);
      visible.value = true;
    };

    const onDelete = (record) => {
      axios.delete("/business/admin/daily-train-station/delete/" + record.id).then((response) => {
        const data = response.data;
        if (data.success) {
          notification.success({description: "删除成功！"});
          handleQuery({
            page: pagination.value.current,
            size: pagination.value.pageSize,
          });
        } else {
          notification.error({description: data.message});
        }
      });
    };

    const handleOk = () => {
      axios.post("/business/admin/daily-train-station/save", dailyTrainStation.value).then((response) => {
        let data = response.data;
        if (data.success) {
          notification.success({description: "保存成功！"});
          visible.value = false;
          handleQuery({
            page: pagination.value.current,
            pageSize: pagination.value.pageSize
          });
        } else {
          notification.error({description: data.message});
        }
      });
    };

    const handleQuery = (param) => {
      if (!param) {
        param = {
          page: 1,
          pageSize: pagination.value.pageSize
        };
      }
      loading.value = true;
      axios.get("/business/admin/daily-train-station/query-list", {
        params: {
          page: param.page,
          pageSize: param.pageSize,
          date: params.value.date,
          trainCode: params.value.trainCode
        }
      }).then((response) => {
        loading.value = false;
        let data = response.data;
        if (data.success) {
          dailyTrainStations.value = data.content.rows;
          // 设置分页控件的值
          pagination.value.current = param.page;
          pagination.value.total = data.content.total;
        } else {
          notification.error({description: data.message});
        }
      });
    };

    const handleTableChange = (page) => {
      // console.log("看看自带的分页参数都有啥：" + JSON.stringify(page));
      pagination.value.pageSize = page.pageSize;
      handleQuery({
        page: page.current,
        pageSize: page.pageSize
      });
    };

    onMounted(() => {
      handleQuery({
        page: 1,
        pageSize: pagination.value.pageSize
      });
    });

    return {
      dailyTrainStation,
      visible,
      dailyTrainStations,
      pagination,
      loading,
      params,
      columns,
      handleTableChange,
      handleQuery,
      onAdd,
      handleOk,
      onEdit,
      onDelete
    };
  },
});
</script>
