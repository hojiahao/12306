<template>
    <p>
        <a-space>
            <a-button type="primary" @click="handleQuery()">刷新</a-button>
            
        </a-space>
    </p>
    <a-table :dataSource="tickets"
             :columns="columns"
             :pagination="pagination"
             @change="handleTableChange"
             :loading="loading">
        <template #bodyCell="{ column, record }">
            <template v-if="column.dataIndex === 'action'">
            </template>
                    <template v-else-if="column.dataIndex === 'seatCol'">
        <span v-for="item in SEAT_COL_ARRAY" :key="item.code">
          <span v-if="item.code === record.seatCol && item.type === record.seatType">
            {{item.desc}}
          </span>
        </span>
                    </template>
                    <template v-else-if="column.dataIndex === 'seatType'">
        <span v-for="item in SEAT_TYPE_ARRAY" :key="item.code">
          <span v-if="item.code === record.seatType">
            {{item.desc}}
          </span>
        </span>
                    </template>
        </template>
    </a-table>
</template>

<script>
    import { defineComponent, ref, onMounted } from 'vue';
    import {notification} from "ant-design-vue";
    import axios from "axios";

    export default defineComponent({
        name: "ticket-view",
        setup() {
            const SEAT_COL_ARRAY = window.SEAT_COL_ARRAY;
            const SEAT_TYPE_ARRAY = window.SEAT_TYPE_ARRAY;
            const visible = ref(false);
            let ticket = ref({
                id: undefined,
                memberId: undefined,
                passengerId: undefined,
                passengerName: undefined,
                trainDate: undefined,
                trainCode: undefined,
                carriageIndex: undefined,
                seatRow: undefined,
                seatCol: undefined,
                departureStation: undefined,
                departureTime: undefined,
                destinationStation: undefined,
                arrivalTime: undefined,
                seatType: undefined,
                createTime: undefined,
                updateTime: undefined,
            });
            const tickets = ref([]);
            // 分页的三个属性名是固定的
            const pagination = ref({
                total: 0,
                current: 1,
                pageSize: 10,
            });
            let loading = ref(false);
            const columns = [
                {
                    title: '会员id',
                    dataIndex: 'memberId',
                    key: 'memberId',
                },
                {
                    title: '乘客id',
                    dataIndex: 'passengerId',
                    key: 'passengerId',
                },
                {
                    title: '乘客姓名',
                    dataIndex: 'passengerName',
                    key: 'passengerName',
                },
                {
                    title: '日期',
                    dataIndex: 'trainDate',
                    key: 'trainDate',
                },
                {
                    title: '车次编号',
                    dataIndex: 'trainCode',
                    key: 'trainCode',
                },
                {
                    title: '箱序',
                    dataIndex: 'carriageIndex',
                    key: 'carriageIndex',
                },
                {
                    title: '排号',
                    dataIndex: 'seatRow',
                    key: 'seatRow',
                },
                {
                    title: '列号',
                    dataIndex: 'seatCol',
                    key: 'seatCol',
                },
                {
                    title: '出发站',
                    dataIndex: 'departureStation',
                    key: 'departureStation',
                },
                {
                    title: '出发时间',
                    dataIndex: 'departureTime',
                    key: 'departureTime',
                },
                {
                    title: '到达站',
                    dataIndex: 'destinationStation',
                    key: 'destinationStation',
                },
                {
                    title: '到站时间',
                    dataIndex: 'arrivalTime',
                    key: 'arrivalTime',
                },
                {
                    title: '座位类型',
                    dataIndex: 'seatType',
                    key: 'seatType',
                },
            ];


            const handleQuery = (param) => {
                if (!param) {
                    param = {
                        page: 1,
                        pageSize: pagination.value.pageSize
                    };
                }
                loading.value = true;
                axios.get("/member/admin/ticket/query-list", {
                    params: {
                        page: param.page,
                        pageSize: param.pageSize
                    }
                }).then((response) => {
                    loading.value = false;
                    let data = response.data;
                    if (data.success) {
                        tickets.value = data.content.rows;
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
                SEAT_COL_ARRAY,
                SEAT_TYPE_ARRAY,
                ticket,
                visible,
                tickets,
                pagination,
                columns,
                handleTableChange,
                handleQuery,
                loading,
            };
        },
    });
</script>
