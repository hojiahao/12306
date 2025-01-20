<template>
  <a-layout-sider width="200" style="background: #fff">
    <a-menu
        v-model:selectedKeys="selectedKeys"
        v-model:openKeys="openKeys"
        mode="inline"
        :style="{ height: '100%', borderRight: 0 }"
    >
<!--      <a-sub-menu key="sub1">-->
<!--        <template #title>-->
<!--              <span>-->
<!--                <user-outlined />-->
<!--                subnav 1-->
<!--              </span>-->
<!--        </template>-->
<!--        <a-menu-item key="1">option1</a-menu-item>-->
<!--        <a-menu-item key="2">option2</a-menu-item>-->
<!--        <a-menu-item key="3">option3</a-menu-item>-->
<!--        <a-menu-item key="4">option4</a-menu-item>-->
<!--      </a-sub-menu>-->
<!--      <a-sub-menu key="sub2">-->
<!--        <template #title>-->
<!--              <span>-->
<!--                <laptop-outlined />-->
<!--                subnav 2-->
<!--              </span>-->
<!--        </template>-->
<!--        <a-menu-item key="5">option5</a-menu-item>-->
<!--        <a-menu-item key="6">option6</a-menu-item>-->
<!--        <a-menu-item key="7">option7</a-menu-item>-->
<!--        <a-menu-item key="8">option8</a-menu-item>-->
<!--      </a-sub-menu>-->
<!--      <a-sub-menu key="sub3">-->
<!--        <template #title>-->
<!--              <span>-->
<!--                <notification-outlined />-->
<!--                subnav 3-->
<!--              </span>-->
<!--        </template>-->
<!--        <a-menu-item key="9">option9</a-menu-item>-->
<!--        <a-menu-item key="10">option10</a-menu-item>-->
<!--        <a-menu-item key="11">option11</a-menu-item>-->
<!--        <a-menu-item key="12">option12</a-menu-item>-->
<!--      </a-sub-menu>-->
      <a-menu-item key="/welcome">
        <router-link to="/welcome">
          <coffee-outlined></coffee-outlined>&nbsp; 欢迎
        </router-link>
      </a-menu-item>
      <a-menu-item key="/passenger">
        <router-link to="/passenger">
          <user-outlined></user-outlined>&nbsp; 乘车人管理
        </router-link>
      </a-menu-item>
    </a-menu>
  </a-layout-sider>
</template>

<script>
import {defineComponent, ref, watch} from 'vue';
import store from "@/store";
import router from "@/router";

export default defineComponent({
  name: "header-view",
  setup() {
    let member = store.state.member;
    const selectedKeys = ref([]);
    watch(() => router.currentRoute.value.path, (newValue) => {
      console.log('watch', newValue);
      selectedKeys.value = [];
      selectedKeys.value.push(newValue);
    }, {immediate: true});
    return {
      selectedKeys,
      member
    };
  },
});
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
