<template>
  <v-card id="lateral">
    <v-toolbar
      dark
      tabs
      flat
      color="#68b1e1"
    >


        <v-tabs
          v-model="tabs"
          align-with-title
        >
          <v-tab href="#one">
            Freunde
          </v-tab>
          <v-tab href="#two">
            Anfragen
          </v-tab>
          <v-tab href="#three">
            Besucher
          </v-tab>
          <v-tabs-slider color="blue"></v-tabs-slider>
        </v-tabs>
    </v-toolbar>
    <v-card-text>
      <v-tabs-items v-model="tabs">
        <v-tab-item
          v-for="content in ['one', 'two', 'three']"
          :key="content"
          :value="content"
        >
          <h3 v-if="content === 'one'">Freunde (58)</h3>
          <div v-if="content === 'one'">Über die Suche findest du deine Freunde auf Spontacts schneller. Gebe hierzu einfach den Vor- und Nachnamen ein.</div>
          <v-card
            v-if="content === 'one'"
            height="500px"
            flat
          >
            <friends-comp></friends-comp>
          </v-card>
        </v-tab-item>
      </v-tabs-items>
    </v-card-text>
  </v-card>
</template>

<script>
import friendsComp from '../../components/FriendsComponent'
export default {
  data: () => ({
    fab: false,
    hidden: false,
    tabs: null,

    messages: [
      {
        avatar: 'https://avatars0.githubusercontent.com/u/9064066?v=4&s=460',
        name: 'John Leider',
        title: 'Welcome to Vuetify!',
        excerpt: 'Thank you for joining our community...',
      },
      {
        color: 'red',
        icon: 'mdi-account-multiple',
        name: 'Social',
        new: 1,
        total: 3,
        title: 'Twitter',
      },
      {
        color: 'teal',
        icon: 'mdi-tag',
        name: 'Promos',
        new: 2,
        total: 4,
        title: 'Shop your way',
        exceprt: 'New deals available, Join Today',
      },
    ],
    lorem: 'Lorem ipsum dolor sit amet, at aliquam vivendum vel, everti delicatissimi cu eos. Dico iuvaret debitis mel an, et cum zril menandri. Eum in consul legimus accusam. Ea dico abhorreant duo, quo illum minimum incorrupte no, nostro voluptaria sea eu. Suas eligendi ius at, at nemore equidem est. Sed in error hendrerit, in consul constituam cum.',
  }),

  components: {
    // eslint-disable-next-line vue/no-unused-components
    friendsComp
  },

  computed: {
    activeFab () {
      switch (this.tabs) {
        case 'one': return { color: 'success', icon: 'mdi-share-variant' }
        case 'two': return { color: 'red', icon: 'mdi-pencil' }
        case 'three': return { color: 'green', icon: 'mdi-chevron-up' }
        default: return {}
      }
    },
  },
}
</script>

<style>
</style>
