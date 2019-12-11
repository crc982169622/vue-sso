<template>
    <div id="index1">
      <h1>这是系统1的主页</h1>
      <h3>{{message}}</h3><br/>
      <a href="#">进入系统2的主页</a>

    </div>
</template>

<script>
    export default {
        name: "index1",
        data () {
          return{
            message: ''
          }
        },
        mounted () {
          this.$axios
            .get('/server1/index', {
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
