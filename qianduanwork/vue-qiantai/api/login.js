import request from '@/utils/request'
export default {

    submitLogin(userInfo) {
      return request({
        url: `/ucenterservice/ucenter-member/login`,
        method: 'post',
        data:userInfo
      })
    },
    getUserInfo() {
      return request({
        url: `/ucenterservice/ucenter-member/getMemberInfo`,
        method: 'get',
      })
    },

}