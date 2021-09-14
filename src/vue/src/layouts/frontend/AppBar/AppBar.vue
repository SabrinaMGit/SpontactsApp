<template>
  <v-app-bar
    app
    color="#68b1e1"
    dark
    elevate-on-scroll
  >
    <v-toolbar-title></v-toolbar-title>

    <v-btn
      icon
      @click="drawer = !drawer"
    >
      <v-icon aria-label="Toggle Drawer">
        {{ (drawer || $vuetify.breakpoint.smAndDown) ? '$menu' : '$close' }}
      </v-icon>
    </v-btn>

    <v-spacer />

    <v-card-text>
      <v-autocomplete
        v-model="model"
        :items="items"
        :loading="isLoading"
        :search-input.sync="search"
        color="white"
        hide-no-data
        hide-selected
        item-text="Description"
        item-value="API"
        label="Suchen"
        placeholder="Suchen"
        prepend-icon="mdi-magnify"
        return-object
      ></v-autocomplete>
    </v-card-text>

    <v-spacer />

    <v-btn
      :to="{ name: 'Home' }"
      exact
      icon
    >
      <v-icon>mdi-bell-outline</v-icon>
    </v-btn>

  </v-app-bar>
</template>

<script>
  // Utilities
  import {
    sync,
  } from 'vuex-pathify'

  export default {
    name: 'FrontendAppBar',
    data: () => ({
      descriptionLimit: 60,
      entries: [],
      isLoading: false,
      model: null,
      search: null,
    }),

    computed: {
      ...sync('frontend/*'),
      fields () {
        if (!this.model) return []

        return Object.keys(this.model).map(key => {
          return {
            key,
            value: this.model[key] || 'n/a',
          }
        })
      },
      items () {
        return this.entries.map(entry => {
          const Description = entry.Description.length > this.descriptionLimit
            ? entry.Description.slice(0, this.descriptionLimit) + '...'
            : entry.Description

          return Object.assign({}, entry, { Description })
        })
      },
    },

    watch: {
      search () {
        // Items have already been loaded
        if (this.items.length > 0) return

        // Items have already been requested
        if (this.isLoading) return

        this.isLoading = true

        // Lazily load input items
        fetch('https://api.publicapis.org/entries')
          .then(res => res.json())
          .then(res => {
            const { count, entries } = res
            this.count = count
            this.entries = entries
          })
          .catch(err => {
            console.log(err)
          })
          .finally(() => (this.isLoading = false))
      },
    },
  }
</script>
