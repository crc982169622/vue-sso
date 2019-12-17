import Vue from 'vue'
import Router from 'vue-router'
import login from '@/components/login'
import index1 from '@/components/index1'
import index2 from '@/components/index2'

Vue.use(Router)

/**
 * 重写路由的push方法
 */
const routerPush = Router.prototype.push
Router.prototype.push = function push(location) {
  return routerPush.call(this, location).catch(error=> error)
}

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'login',
      component: login
    },
    {
      path: '/index1',
      name: 'index1',
      component: index1
    },
    {
      path: '/index2',
      name: 'index2',
      component: index2
    }
  ]
})
