<template>

    <div>
        <div class="detail-title">
        Address
        </div>
        <v-col>
            <String label="Street" v-model="value.street" :editMode="editMode"/>
            <String label="City" v-model="value.city" :editMode="editMode"/>
            <String label="State" v-model="value.state" :editMode="editMode"/>
            <String label="Country" v-model="value.country" :editMode="editMode"/>
            <String label="ZipCode" v-model="value.zipcode" :editMode="editMode"/>
        </v-col>

        <v-card-actions v-if="inList">
            <slot name="actions"></slot>
        </v-card-actions>
    </div>
</template>

<script>
import BaseEntity from './base-ui/BaseEntity'

export default {
    name: 'Address',
    mixins:[BaseEntity],
    components:{
    },
    data: () => ({
        path: 'Address',
    }),
    props: {
    },
    watch: {
        value(val){
            this.value = val;
            this.change();
        },
    },
    async created(){
        if (this.value && this.value.id !== undefined) {
            this.value = await this.repository.findById(this.value.id)
        }
    },
    methods: {
        pick(val){
            this.value = val;
            this.change();
        },
    }
}
</script>

