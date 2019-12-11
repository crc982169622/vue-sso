<template>
  <div id="index2">
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
        }
    }
</script>

<style scoped>

</style>
