

<template>
    <v-app id="inspire">
        <div>
            <v-app-bar color="primary" app clipped-left flat>
                <v-toolbar-title>
                    <span class="second-word font uppercase"
                        style="font-weight:700;"
                    >
                        <v-app-bar-nav-icon
                            @click="openSideBar()"
                            style="z-index:1;
                            height:56px;
                            width:30px;
                            margin-right:10px;
                            font-weight:300;
                            font-size:55px;"
                        >
                            <div style="line-height:100%;">≡</div>
                        </v-app-bar-nav-icon>
                    </span>
                </v-toolbar-title>
                <span v-if="urlPath!=null" 
                    class="mdi mdi-home" 
                    key="" 
                    to="/" 
                    @click="goHome()"
                    style="margin-left:10px; font-size:20px; cursor:pointer;"
		        ></span> 
                <v-spacer></v-spacer>

            </v-app-bar>

            <v-navigation-drawer app clipped flat v-model="sideBar">
                <v-list>
                    <v-list-item
                        class="px-2"
                        key="customers"
                        to="/customerManagements/customers"
                        @click="changeUrl()"
                        color="primary"
                        style="font-weight:700;"
                    >
                        고객
                    </v-list-item>


                    <v-list-item
                        class="px-2"
                        key="stores"
                        to="/orderManagements/stores"
                        @click="changeUrl()"
                        color="primary"
                        style="font-weight:700;"
                    >
                        상점
                    </v-list-item>

                    <v-list-item
                        class="px-2"
                        key="orders"
                        to="/orderManagements/orders"
                        @click="changeUrl()"
                        color="primary"
                        style="font-weight:700;"
                    >
                        주문
                    </v-list-item>

                    <v-list-item
                        class="px-2"
                        key="payments"
                        to="/orderManagements/payments"
                        @click="changeUrl()"
                        color="primary"
                        style="font-weight:700;"
                    >
                        결제
                    </v-list-item>


                    <v-list-item
                        class="px-2"
                        key="riders"
                        to="/deliveryManagements/riders"
                        @click="changeUrl()"
                        color="primary"
                        style="font-weight:700;"
                    >
                        라이더
                    </v-list-item>

                    <v-list-item
                        class="px-2"
                        key="deliveries"
                        to="/deliveryManagements/deliveries"
                        @click="changeUrl()"
                        color="primary"
                        style="font-weight:700;"
                    >
                        배달
                    </v-list-item>


                    <v-list-item
                        class="px-2"
                        key="notifications"
                        to="/notificationManagements/notifications"
                        @click="changeUrl()"
                        color="primary"
                        style="font-weight:700;"
                    >
                        알림
                    </v-list-item>


                </v-list>
            </v-navigation-drawer>
        </div>

        <v-main>
            <v-container style="padding:0px;" v-if="urlPath" fluid>
                <router-view></router-view>
            </v-container>
            <v-container style="padding:0px;" v-else fluid>
                <div style="width:100%; margin:0px 0px 20px 0px; position: relative;">
                    <v-img style="width:100%; height:300px;"
                        src=""
                    ></v-img>
                    <div class="App-main-text-overlap"></div>
                    <div class="App-sub-text-overlap"></div>
                </div>
                <v-row>
                    <v-col cols="4" class="d-flex justify-center" v-for="(aggregate, index) in aggregate" :key="index">
                        <div 
                            class="flip-card"
                            @mouseover="flipCard(index)"
                            @mouseleave="unflipCard(index)"
                            :class="{ 'is-flipped': flipped[index] }"
                        >
                            <div class="flip-card-inner">
                                <div class="flip-card-front">
                                    <v-card
                                        class="mx-auto"
                                        style="width:300px; min-height: 310px; margin-bottom:20px; text-align: center; border-radius: 10px;"
                                        outlined
                                    >
                                        <v-list-item style="padding:15px; margin:0px;">
                                            <v-img style="width:100%; height:120px; border-radius: 10px;" :src="aggregate.ImageUrl"></v-img>
                                        </v-list-item>
                                        <div style="text-align: left; padding:10px 15px 15px 15px; margin-top:-10px;">
                                            <h2>{{ aggregate.title }}</h2>
                                            <div>{{ aggregate.description }}</div>
                                        </div>
                                    </v-card>
                                </div>
                                <div class="flip-card-back">
                                    <v-card
                                        color="primary"
                                        class="mx-auto"
                                        style="width:300px; min-height: 310px; margin-bottom:20px; text-align: center; border-radius: 10px;"
                                        outlined
                                        :key="aggregate.key"
                                        :to="aggregate.route"
                                        @click="changeUrl()"
                                    >
                                        <v-list-item style="padding:15px; margin:0px;">
                                            <v-img style="width:100%; height:120px; border-radius: 10px;" :src="aggregate.ImageUrl"></v-img>
                                        </v-list-item>
                                        <h2 style="color:white;">{{ aggregate.title }} 관리</h2>
                                    </v-card>
                                </div>
                            </div>
                        </div>
                    </v-col>
                </v-row>
            </v-container>
        </v-main>
    </v-app>
</template>

<script>

export default {
    name: "App",
    data: () => ({
        useComponent: "",
        drawer: true,
        components: [],
        sideBar: true,
        urlPath: null,
        flipped: [],
        ImageUrl: '',
        aggregate: [
            { 
                title: '고객', 
                description: '고객 정보를 관리합니다.', 
                key: 'customers', 
                route: '/customerManagements/customers',
                ImageUrl: '',
            },
            { 
                title: '상점', 
                description: '상점 정보를 관리합니다.', 
                key: 'stores', 
                route: '/orderManagements/stores',
                ImageUrl: '',
            },
            { 
                title: '주문', 
                description: '주문 정보를 관리합니다.', 
                key: 'orders', 
                route: '/orderManagements/orders',
                ImageUrl: '',
            },
            { 
                title: '결제', 
                description: '결제 정보를 관리합니다.', 
                key: 'payments', 
                route: '/orderManagements/payments',
                ImageUrl: '',
            },
            { 
                title: '라이더', 
                description: '라이더 정보를 관리합니다.', 
                key: 'riders', 
                route: '/deliveryManagements/riders',
                ImageUrl: '',
            },
            { 
                title: '배달', 
                description: '배달 정보를 관리합니다.', 
                key: 'deliveries', 
                route: '/deliveryManagements/deliveries',
                ImageUrl: '',
            },
            { 
                title: '알림', 
                description: '알림 정보를 관리합니다.', 
                key: 'notifications', 
                route: '/notificationManagements/notifications',
                ImageUrl: '',
            },
            
        ],
    }),
    
    async created() {
      var path = document.location.href.split("#/")
      this.urlPath = path[1];

    },
    watch: {
        cards(newCards) {
            this.flipped = new Array(newCards.length).fill(false);
        },
    },

    mounted() {
        var me = this;
        me.components = this.$ManagerLists;
    },

    methods: {
        openSideBar(){
            this.sideBar = !this.sideBar
        },
        changeUrl() {
            var path = document.location.href.split("#/")
            this.urlPath = path[1];
            this.flipped.fill(false);
        },
        goHome() {
            this.urlPath = null;
        },
        flipCard(index) {
            this.$set(this.flipped, index, true);
        },
        unflipCard(index) {
            this.$set(this.flipped, index, false);
        },
    }
};
</script>
<style>
</style>
