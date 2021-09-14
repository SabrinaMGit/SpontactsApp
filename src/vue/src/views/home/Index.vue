<template>
  <div>
    <v-container
      class="white lighten-5 mb-6"
    >

      <v-row>
        <v-col>
          <v-card
            max-width="375"
            class="mx-auto"
          >
            <v-img
              src="https://cdn.vuetifyjs.com/images/lists/ali.png"
              height="250px"
              dark
            >
              <v-row align="center" justify="center">

                <v-card-title class="white--text text-center">
                  <div class="text-h6 col-15">
                    Hey Sabrina, entdecke neue Aktivitäten in deiner Nähe.
                  </div>
                </v-card-title>
              </v-row>

              <v-container>
                <v-row
                  no-gutters
                >
                  <v-col
                    v-for="n in itemsTop"
                    :key="n"
                    class="text-center"
                  >
                    <v-btn
                      depressed
                      color="#68b1e1"
                    >
                      {{n.text}}
                    </v-btn>
                  </v-col>
                </v-row>
              </v-container>
            </v-img>
          </v-card>
        </v-col>
      </v-row>

      <v-row>
        <v-col>
          <v-card
            class="mx-auto"
            max-width="500"
          >
            <v-list>
              <v-list-item-group v-model="model">
                <v-list-item
                  v-for="(item, i) in items"
                  :key="i"
                >
                  <v-list-item-content>
                    <v-list-item-title v-text="item.text"></v-list-item-title>
                  </v-list-item-content>
                </v-list-item>
              </v-list-item-group>
            </v-list>
          </v-card>
        </v-col>
      </v-row>

        <v-row>
          <v-col
            v-for="n in itemFields"
            :key="n"
            class="d-flex child-flex"
            cols="6"
          >
            <v-img
              :src="`https://picsum.photos/500/300?image=${n.no * 5 + 10}`"
              :lazy-src="`https://picsum.photos/10/6?image=${n.no * 5 + 10}`"
              aspect-ratio="1"
              gradient="to top right, rgba(100,115,201,.33), rgba(25,32,72,.7)"
            >
              <v-card-title class="white--text">
                <div class="text-h6">
                  {{n.text}}
                </div>
              </v-card-title>
            </v-img>
          </v-col>
        </v-row>
    </v-container>
  </div>
</template>

<script>

export default {
  data: () => ({
    length: 5,
    onboarding: 0,
    items: [
      { text: 'Heute' },
      { text: 'Morgen' },
      { text: 'Wochenende' }
    ],
    itemsTop: [
      { text: 'Alle' },
      { text: 'Empfohlen' },
      { text: 'Meine' }
    ],
    model: 1,
    alignments: [
      'start',
      'center',
      'end',
    ],
    itemFields: [
      { no: 1, text: 'SPORT' },
      { no: 2,text: 'KULTUR' },
      { no: 3,text: 'ERHOLUNG' },
      { no: 4,text: 'AUSGEHEN' },
      { no: 5,text: 'GUTES TUN' },
      { no: 6,text: 'TIERE' },
    ]
  }),

  methods: {
    next () {
      this.onboarding = this.onboarding + 1 === this.length
        ? 0
        : this.onboarding + 1
    },
    prev () {
      this.onboarding = this.onboarding - 1 < 0
        ? this.length - 1
        : this.onboarding - 1
    },
  },
}
</script>
