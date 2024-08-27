
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import CustomerManagementCustomerManager from "./components/listers/CustomerManagementCustomerCards"
import CustomerManagementCustomerDetail from "./components/listers/CustomerManagementCustomerDetail"

import OrderManagementStoreManager from "./components/listers/OrderManagementStoreCards"
import OrderManagementStoreDetail from "./components/listers/OrderManagementStoreDetail"
import OrderManagementOrderManager from "./components/listers/OrderManagementOrderCards"
import OrderManagementOrderDetail from "./components/listers/OrderManagementOrderDetail"
import OrderManagementPaymentManager from "./components/listers/OrderManagementPaymentCards"
import OrderManagementPaymentDetail from "./components/listers/OrderManagementPaymentDetail"

import DeliveryManagementRiderManager from "./components/listers/DeliveryManagementRiderCards"
import DeliveryManagementRiderDetail from "./components/listers/DeliveryManagementRiderDetail"
import DeliveryManagementDeliveryManager from "./components/listers/DeliveryManagementDeliveryCards"
import DeliveryManagementDeliveryDetail from "./components/listers/DeliveryManagementDeliveryDetail"

import NotificationManagementNotificationManager from "./components/listers/NotificationManagementNotificationCards"
import NotificationManagementNotificationDetail from "./components/listers/NotificationManagementNotificationDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/customerManagements/customers',
                name: 'CustomerManagementCustomerManager',
                component: CustomerManagementCustomerManager
            },
            {
                path: '/customerManagements/customers/:id',
                name: 'CustomerManagementCustomerDetail',
                component: CustomerManagementCustomerDetail
            },

            {
                path: '/orderManagements/stores',
                name: 'OrderManagementStoreManager',
                component: OrderManagementStoreManager
            },
            {
                path: '/orderManagements/stores/:id',
                name: 'OrderManagementStoreDetail',
                component: OrderManagementStoreDetail
            },
            {
                path: '/orderManagements/orders',
                name: 'OrderManagementOrderManager',
                component: OrderManagementOrderManager
            },
            {
                path: '/orderManagements/orders/:id',
                name: 'OrderManagementOrderDetail',
                component: OrderManagementOrderDetail
            },
            {
                path: '/orderManagements/payments',
                name: 'OrderManagementPaymentManager',
                component: OrderManagementPaymentManager
            },
            {
                path: '/orderManagements/payments/:id',
                name: 'OrderManagementPaymentDetail',
                component: OrderManagementPaymentDetail
            },

            {
                path: '/deliveryManagements/riders',
                name: 'DeliveryManagementRiderManager',
                component: DeliveryManagementRiderManager
            },
            {
                path: '/deliveryManagements/riders/:id',
                name: 'DeliveryManagementRiderDetail',
                component: DeliveryManagementRiderDetail
            },
            {
                path: '/deliveryManagements/deliveries',
                name: 'DeliveryManagementDeliveryManager',
                component: DeliveryManagementDeliveryManager
            },
            {
                path: '/deliveryManagements/deliveries/:id',
                name: 'DeliveryManagementDeliveryDetail',
                component: DeliveryManagementDeliveryDetail
            },

            {
                path: '/notificationManagements/notifications',
                name: 'NotificationManagementNotificationManager',
                component: NotificationManagementNotificationManager
            },
            {
                path: '/notificationManagements/notifications/:id',
                name: 'NotificationManagementNotificationDetail',
                component: NotificationManagementNotificationDetail
            },



    ]
})
