<template>
  <div id="index2">
    <Button type="primary" style="margin-left: 24%;" @click="loginout">退出登录</Button>
    <h1>这是系统2的主页</h1>
    <h3>{{message}}</h3><br/>
    <router-link to="/index1"><a href="#">进入系统1的主页</a></router-link>
  </div>
</template>

<script>
    export default {
        name: "index2",
        data () {
          return{
            message: ''
          }
        },
        mounted () {
          this.$axios
            .get('/server2/index', {
              params: {
                token: this.getCookie('token')
              }
            })
            .then(response => {
              if (response.data.stateInfo == 'success') {
                this.message = response.data.message
              }
            })
        },
        methods: {
          loginout: function () {
            this.delCookie("token")
            this.$router.go(0);
          }
        }
    }
</script>

<style scoped>

</style>
