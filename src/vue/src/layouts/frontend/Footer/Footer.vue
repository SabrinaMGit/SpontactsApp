<template>
  <v-footer
    app
    height="60"
  >
    <v-card
      class="overflow-hidden mx-auto"
      max-width="100%"
    >
      <v-bottom-navigation
        hide-on-scroll
        horizontal
        scroll-target="#hide-on-scroll-example"
      >
        <v-btn
          color="blue"
          text
          :to="{ name: 'Home' }"
          exact
          icon
        >

          <v-icon>mdi-home</v-icon>
        </v-btn>

        <v-btn
          color="blue"
          text
          :to="{ name: 'Dashboard' }"
          exact
          icon
        >

          <v-icon>mdi-map-marker</v-icon>
        </v-btn>

        <v-btn
          color="blue"
          text
          :to="{ name: 'Newactiv' }"
          exact
          icon
        >

          <v-icon>mdi-plus-circle</v-icon>
        </v-btn>

        <v-btn
          color="blue"
          text
          :to="{ name: 'Home' }"
          exact
          icon
        >

          <v-icon>mdi-forum-outline</v-icon>
        </v-btn>
      </v-bottom-navigation>

      <v-responsive
        id="hide-on-scroll-example"
        class="overflow-y-auto"
        max-height="600"
      >
        <v-responsive height="1500"></v-responsive>
      </v-responsive>
    </v-card>
  </v-footer>
</template>

<script>
  export default {
    name: 'FrontendFooter',

    data: () => ({
      date: (new Date()).getFullYear(),
    }),
  }
</script>
