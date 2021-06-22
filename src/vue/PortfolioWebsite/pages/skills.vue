<template>
  <v-row class="d-flex" justify="center">
    <v-menu absolute offset-y style="max-width: 600px">
      <template v-slot:activator="{ on, attrs }">
        <v-card
          class="portrait"
          img="https://cdn.vuetifyjs.com/images/cards/girl.jpg"
          height="300"
          width="600"
          v-bind="attrs"
          v-on="on"
        ></v-card>
      </template>
    </v-menu>
  </v-row>
</template>
