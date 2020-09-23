import request from '@/utils/request'
export default {

  CreateOrder(courseId) {
    return request({
      url: `/eduorder/t-order/createOrder/${courseId}`,
      method: 'post'
    })
  },
  getOrderInfo(orderId) {
    return request({
      url: `/eduorder/t-order/getOrderInfo/${orderId}`,
      method: 'get'
    })
  },
    createNative(orderNo) {
    return request({
      url: `/eduorder/t-pay-log/createNative/${orderNo}`,
      method: 'get'
    })
  },
  queryPayStatus(orderNo) {
    return request({
      url: `/eduorder/t-pay-log/queryPayStatus/${orderNo}`,
      method: 'get'
    })
  },
}