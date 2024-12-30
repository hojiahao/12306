<template>
  <a-row class="login">
    <a-col :span="8" :offset="8" class="login">
      <h1 style="text-align: center"><rocket-two-tone />欢迎登录12306</h1>
      <!-- 登录方式切换 -->
      <div style="text-align: center; margin-bottom: 20px; font-size: 14px; font-weight: bold;">
        <a :class="currentTab === 'password' ? 'active-tab' : ''" @click="currentTab = 'password'" style="margin-left: 20px">密码登录</a>
        <a :class="currentTab === 'sms' ? 'active-tab' : ''" @click="currentTab = 'sms'" style="margin-left: 20px">短信登录</a>
      </div>

      <!-- 短信登录内容 -->
      <a-form
          v-if="currentTab === 'sms'"
          :model="smsFormState"
          name="sms_login"
          class="login-form"
          @finish="onSmsFinish"
          @finishFailed="onFinishFailed"
      >
        <a-form-item
            name="phone"
            :rules="[
            { required: true, message: '请输入手机号' },
            { pattern: /^\\d{11}$/, message: '手机号格式不正确' },
          ]"
        >
          <a-input-group compact>
            <a-select
                v-model:value="smsFormState.areaCode"
                placeholder="选择国家区号"
                style="width: 40%"
            >
              <a-select-option value="+86">中国 +86</a-select-option>
              <a-select-option value="+1">美国 +1</a-select-option>
              <a-select-option value="+44">英国 +44</a-select-option>
              <a-select-option value="+91">印度 +91</a-select-option>
              <a-select-option value="+81">日本 +81</a-select-option>
              <a-select-option value="+49">德国 +49</a-select-option>
            </a-select>
            <a-input v-model:value="smsFormState.phone" placeholder="请输入手机号" style="width: 60%; text-align: left; padding-left: 8px;" />
          </a-input-group>
        </a-form-item>

        <a-form-item
            name="smsCode"
            :rules="[{ required: true, message: '请输入验证码' }]"
        >
          <a-input v-model:value="smsFormState.smsCode" placeholder="请输入验证码">
            <template #suffix>
              <a
                  :disabled="isCounting"
                  style="color: #1890ff; cursor: pointer"
                  @click="getSmsCode"
              >
                {{ isCounting ? `${countdown}s后重试` : '获取验证码' }}
              </a>
            </template>
          </a-input>
        </a-form-item>

        <a-form-item>
          <a-button
              :disabled="disabledSms"
              type="primary"
              html-type="submit"
              class="login-form-button">Log in
          </a-button>
          Or
          <a href="">register now!</a>
        </a-form-item>
      </a-form>

      <!-- 密码登录内容 -->
      <a-form
          v-if="currentTab === 'password'"
          :model="passwordformState"
          name="password_login"
          class="login-form"
          @finish="onFinish"
          @finishFailed="onFinishFailed"
      >
        <a-form-item
            label=""
            name="username"
            :rules="[{ required: true, message: 'Please input your username/email/phone'}]"
        >
          <a-input v-model:value="passwordformState.username" placeholder="Enter username/email/phone" >
            <template #prefix>
              <UserOutlined class="site-form-item-icon" />
            </template>
          </a-input>
        </a-form-item>

        <a-form-item
            label=""
            name="password"
            :rules="[{ required: true, message: 'Please input your password!' }]"
        >
          <a-input-password v-model:value="passwordformState.password" placeholder="Enter password" >
            <template #prefix>
              <LockOutlined class="site-form-item-icon" />
            </template>
          </a-input-password>
        </a-form-item>

        <a-form-item>
          <a-form-item name="remember" no-style>
            <a-checkbox v-model:checked="passwordformState.remember">Remember me</a-checkbox>
          </a-form-item>
          <a class="login-form-forgot" href="">Forgot password</a>
        </a-form-item>

        <a-form-item>
          <a-button :disabled="disabledPassword" type="primary" html-type="submit" class="login-form-button">
            Log in
          </a-button>
          Or
          <a href="">register now!</a>
        </a-form-item>
      </a-form>
    </a-col>
  </a-row>
</template>
<script setup>
import { reactive, ref, computed } from 'vue'
const currentTab = ref('password');
const smsFormState = reactive({
  areaCode: "+86",
  phone: "",
  smsCode: ""
});
const passwordformState = reactive({
  username: '',
  password: '',
  remember: true,
});

const countdown =  ref(60);

const isCounting = computed(() => {
  return countdown.value < 60
});

let interval = null;
const getSmsCode = () => {
  if (isCounting.value || smsFormState.phone) {
    return;
  }
  countdown.value = 60;
  interval = setInterval(() => {
    if (countdown.value < 0) {
      countdown.value -= 1;
    }
    else {
      clearInterval(interval);
    }
  }, 1000);
};
const disabledSms = computed(() => {
  return (!smsFormState.phone || !smsFormState.smsCode);
})
const onSmsFinish = values => {
  console.log('SMS login successful:', values);
};
const onFinish = values => {
  console.log('Password login successful:', values);
};
const onFinishFailed = errorInfo => {
  console.log('Login failed:', errorInfo);
};
const disabledPassword = computed(() => {
  return !(passwordformState.username && passwordformState.password);
})
</script>
<style scoped>
.login-main h1 {
  font-size: 25px;
  font-weight: bold;
}
.login-main {
  margin-top: 100px;
  padding: 30px 30px 20px;
  border: 2px solid grey;
  border-radius: 10px;
  background-color: #fcfcfc;
}
</style>