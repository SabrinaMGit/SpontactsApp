<template>
  <v-navigation-drawer
    v-model="drawer"
    :disable-route-watcher="$vuetify.breakpoint.smAndUp"
    app
    disable-resize-watcher
    width="300"
  >
    <template v-slot:prepend>
      <v-card
        class="mx-auto"
        max-width="344"
        outlined
      >
        <v-list-item three-line>
          <v-list-item-avatar
            tile
            size="80"
            color="grey"
          >
            <img src="https://randomuser.me/api/portraits/women/81.jpg">
          </v-list-item-avatar>
          <v-list-item-content>
            <div class="text-overline mb-4">
              Sabrina M.
            </div>
            <v-list-item-title class="text-h9 mb-1">
              Ich nutze Spontacts
            </v-list-item-title>
            <v-list-item-title class="text-h9 mb-1">
              BASIC
            </v-list-item-title>
          </v-list-item-content>

        </v-list-item>

            <v-list dense>
              <v-list-item-group
                v-model="selectedItem"
                color="primary"
              >
                <v-list-item
                  v-for="(item, i) in itemOrgan"
                  :key="i"
                >
                  <v-list-item-icon>
                    <v-icon v-text="item.icon"></v-icon>
                  </v-list-item-icon>
                  <v-list-item-content>
                    <v-list-item-title v-text="item.text"></v-list-item-title>
                  </v-list-item-content>
                </v-list-item>
              </v-list-item-group>
            </v-list>
      </v-card>
    </template>

    <v-list nav v-for="(item, i) in items" :key="i">
      <v-list-item
        v-if="i < items.length-1"
        :to="item.to"
        exact
      >

          <v-list-item-icon>
            <v-icon v-text="item.icon" />
          </v-list-item-icon>

          <v-list-item-content>
            <v-list-item-title v-text="item.text" />
          </v-list-item-content>

      </v-list-item>

          <v-list-item
            v-if="i === items.length-1"
            :to="item.to"
            exact
            class="navRed"
          >

              <v-list-item-icon>
                <v-icon v-text="item.icon"></v-icon>
              </v-list-item-icon>
              <v-list-item-content>
                <v-list-item-title v-text="item.text"></v-list-item-title>
              </v-list-item-content>

          </v-list-item>
      </v-list>
  </v-navigation-drawer>
</template>

<script>
// Utilities
import {
  sync,
} from 'vuex-pathify'

export default {
  name: 'FrontendDrawer',
  data: () => ({
    itemOrgan: [
      { icon: 'mdi-file-certificate-outline', text: '13 Ausgezeichnet Organisator'},
      { icon: 'mdi-file-certificate-outline', text: '13 Augezeichnet Teilnehmer'},
    ],
  }),

  computed: {
    ...sync('frontend/*'),
  },
}
</script>

<style scoped>
.navRed {
  background: red;
}
</style>
