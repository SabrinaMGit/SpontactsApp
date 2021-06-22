<template>
  <v-row>
    <v-col
      v-for="(n, index) in images"
      :key="index"
      class="d-flex child-flex"
      cols="4"
    >
      <router-link :to="`/gridPages/${n.name}`">
        <v-img
          :src="require(`@/assets/gridimages/${n.name}.png`)"
          :lazy-src="require(`@/assets/gridimages/${n.name}.png`)"
          aspect-ratio="1"
          class="white lighten-2"
        >
          <template v-slot:placeholder>
            <v-row class="fill-height ma-0" align="center" justify="center">
              <v-progress-circular
                indeterminate
                color="grey lighten-5"
              ></v-progress-circular>
            </v-row>
          </template>
        </v-img>
      </router-link>
    </v-col>
  </v-row>
</template>

<script>
export default {
  name: 'deployment',
  data: () => ({
    images: [
      { name: 'docker' },
      { name: 'git' },
      { name: 'postgresql' },
      { name: 'ssh' },
      { name: 'jenkins' },
      { name: 'bitbucket' },
      { name: 'maven' },
      { name: 'gradle' },
      { name: 'github' },
    ],
  }),
}
</script>
