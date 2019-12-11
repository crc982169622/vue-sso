<template>
    <div id="login" style="width: 50%">
      <Form :model="user" :rules="ruleValidate" ref="user" label-position="right" :label-width="100">
        <FormItem label="用户名" prop="userName">
          <Input v-model="user.userName"></Input>
        </FormItem>
        <FormItem label="密码" prop="password">
          <Input type="password" v-model="user.password"></Input>
        </FormItem>
        <FormItem>
          <Button type="primary" @click="handleSubmit('user')">登录</Button>
        </FormItem>
      </Form>
    </div>
</template>

<script>
    import qs from 'qs'
    export default {
        name: "login",
        data () {
          return {
            user: {
              userName: '',
              password: ''
            },
            ruleValidate: {
              userName: [
                { required: true, message: '用户名不能为空', trigger: 'blur' }
              ],
              password: [
                { required: true, message: '密码不能为空', trigger: 'blur' }
              ]
            }
          }
        },
        methods: {
          handleSubmit (name) {
            this.$refs[name].validate((valid) => {
              if (valid) {
                this.$axios
                  .post('/sso/login', qs.stringify(this.user))
                  .then(response => {
                    if (response.data.stateInfo == 'success') {
                      this.setCookie("token", response.data.message)
                      this.$router.push({path: '/index1'})
                    } else {
                      this.$Message.error(response.data.message);
                    }
                  })


              } else {
                this.$Message.error('Fail!');
              }
            })
          }
        }
    }
</script>

<style scoped>

</style>
