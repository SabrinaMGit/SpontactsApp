<template>
  <v-row justify="center">
    <v-col
      cols="12"
      sm="8"
      md="6"
    >
      <v-card>

        <v-list two-line>
          <template v-for="(item, index) in items">
            <v-subheader
              v-if="item.header"
              :key="item.header"
              :to="item.to"
              inset
            >
              {{
                item.header
              }}
            </v-subheader>

            <v-divider
              v-else-if="item.divider"
              :key="index"
              inset
            ></v-divider>

            <v-list-item
              v-else
              :key="item.title"
              :to="item.to"
              exact
            >
              <v-list-item-avatar>
                <img :src="item.avatar">
              </v-list-item-avatar>
              <v-list-item-content>
                <v-list-item-title v-html="item.title"></v-list-item-title>
                <v-list-item-subtitle
                  v-html="item.subtitle"
                ></v-list-item-subtitle>
              </v-list-item-content>
            </v-list-item>
          </template>
        </v-list>
      </v-card>
    </v-col>
  </v-row>
</template>

<script>
export default {
  name: 'Dashboard',
  data () {
    return {
      items: [
        {
          header: 'Heute',
        },
        { divider: true },
        {
          avatar: 'https://picsum.photos/250/300?image=660',
          title: 'Meeting @ Noon',
          subtitle:
            `<span class="font-weight-bold">Spike Lee</span> &mdash; I'll be in your neighborhood`,
          to: { name: 'Home' },
        },
        {
          avatar: 'https://picsum.photos/250/300?image=821',
          title: 'Summer BBQ <span class="grey--text text--lighten-1"></span>',
          subtitle:
            '<span class="font-weight-bold">to Operations support</span> &mdash; Wish I could come.',
          to: { name: 'Home' },
        },
        {
          avatar: 'https://picsum.photos/250/300?image=783',
          title: 'Yes yes',
          subtitle:
            '<span class="font-weight-bold">Bella</span> &mdash; Do you have Paris recommendations',
          to: { name: 'Home' },
        },
        {
          header: 'Morgen',
        },
        { divider: true },
        {
          avatar: 'https://picsum.photos/250/300?image=1006',
          title: 'Dinner tonight?',
          subtitle:
            '<span class="font-weight-bold">LaToya</span> &mdash; Do you want to hang out?',
          to: { name: 'Home' },
        },
        {
          avatar: 'https://picsum.photos/250/300?image=146',
          title: 'So long',
          subtitle:
            '<span class="font-weight-bold">Nancy</span> &mdash; Do you see what time it is?',
          to: { name: 'Home' },
        },
        {
          header: 'Wochenende',
        },
        { divider: true },
        {
          avatar: 'https://picsum.photos/250/300?image=1008',
          title: 'Breakfast?',
          subtitle:
            '<span class="font-weight-bold">LaToya</span> &mdash; Do you want to hang out?',
          to: { name: 'Home' },
        },
        {
          avatar: 'https://picsum.photos/250/300?image=839',
          title:
            'Winter Porridge <span class="grey--text text--lighten-1"></span>',
          subtitle:
            '<span class="font-weight-bold">cc: Daniel</span> &mdash; Tell me more...',
          to: { name: 'Home' },
        },
        {
          avatar: 'https://picsum.photos/250/300?image=145',
          title: 'Oui oui',
          subtitle:
            '<span class="font-weight-bold">Nancy</span> &mdash; Do you see what time it is?',
          to: { name: 'Home' },
        },
      ],
    }
  },
}
</script>
