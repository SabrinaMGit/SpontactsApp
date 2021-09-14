<template>
  <div>
    <v-container
      class="white lighten-5 mb-6"
    >
      <v-row>
        <v-col>
          <v-card
            class="mx-auto"
            max-width="434"
            tile
          >
            <v-img
              height="100%"
              src="https://cdn.vuetifyjs.com/images/cards/server-room.jpg"
            >
              <v-row
                align="end"
                class="fill-height"
              >
                <v-col
                  align-self="start"
                  class="pa-0"
                  cols="12"
                >
                  <v-avatar
                    class="profile"
                    color="grey"
                    size="164"
                    tile
                  >
                    <v-img src="https://cdn.vuetifyjs.com/images/profiles/marcus.jpg"></v-img>
                  </v-avatar>
                </v-col>
                <v-col class="py-0">
                  <v-list-item
                    color="rgba(0, 0, 0, .4)"
                    dark
                  >
                    <v-list-item-content>
                      <v-list-item-title class="text-h6">
                        Marcus Obrien
                      </v-list-item-title>
                      <v-list-item-subtitle>Network Engineer</v-list-item-subtitle>
                    </v-list-item-content>
                  </v-list-item>
                </v-col>
              </v-row>
            </v-img>
          </v-card>
        </v-col>
      </v-row>

      <v-row>
        <v-col>
          <v-card
            class="overflow-hidden"
            color="white lighten-1"

          >
            <v-toolbar
              flat
              color="blue"
            >
              <v-icon>mdi-account</v-icon>
              <v-toolbar-title class="font-weight-dark">
                User Profile
              </v-toolbar-title>
              <v-spacer></v-spacer>
              <v-btn
                color="blue darken-3"
                fab
                small
                @click="isEditing = !isEditing"
              >
                <v-icon v-if="isEditing">
                  mdi-close
                </v-icon>
                <v-icon v-else>
                  mdi-pencil
                </v-icon>
              </v-btn>
            </v-toolbar>
            <v-card-text>
              <v-text-field
                :disabled="!isEditing"
                color="black"
                label="Vorname"
              ></v-text-field>
              <v-text-field
                :disabled="!isEditing"
                color="black"
                label="Nachname"
              ></v-text-field>
              <v-text-field
                :disabled="!isEditing"
                color="black"
                label="Über Mich"
              ></v-text-field>
              <v-text-field
                :disabled="!isEditing"
                color="black"
                label="Aktueller Wohnort"
              ></v-text-field>
              <v-text-field
                :disabled="!isEditing"
                color="black"
                label="Geschlecht"
              ></v-text-field>
              <v-text-field
                :disabled="!isEditing"
                color="black"
                label="Geburtstag"
              ></v-text-field>
              <v-text-field
                :disabled="!isEditing"
                color="black"
                label="Beziehungsstatus"
              ></v-text-field>
              <v-text-field
                :disabled="!isEditing"
                color="black"
                label="Status"
              ></v-text-field>
              <v-autocomplete
                :disabled="!isEditing"
                :items="states"
                :filter="customFilter"
                color="black"
                item-text="name"
                label="Wohnort"
              ></v-autocomplete>

            </v-card-text>
            <v-divider></v-divider>
            <v-card-actions>
              <v-spacer></v-spacer>
              <v-btn
                :disabled="!isEditing"
                color="success"
                @click="save"
              >
                Save
              </v-btn>
            </v-card-actions>
            <v-snackbar
              v-model="hasSaved"
              :timeout="2000"
              absolute
              bottom
              left
            >
              Your profile has been updated
            </v-snackbar>
          </v-card>
        </v-col>
      </v-row>

      <v-row justify="space-around">
        <v-col
          cols="12"
          sm="10"
          md="8"
        >
          <v-sheet
            elevation="10"
            class="py-4 px-1"
          >
            <v-chip-group
              mandatory
              active-class="primary--text"
            >
              <v-chip
                v-for="tag in tags"
                :key="tag"
              >
                {{ tag }}
              </v-chip>
            </v-chip-group>
          </v-sheet>
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
                >
                  <v-list-item-content>
                    <h4>Statistiken & Auszeichnungen </h4>
                    <v-list-item-title> • 13 x als Organisator ausgezeichnet </v-list-item-title>
                    <v-list-item-title> • 13 x als Teilnehmer ausgezeichnet </v-list-item-title>
                    <v-list-item-title> • Dabei seit 11.März 2019 </v-list-item-title>
                  </v-list-item-content>
                </v-list-item>
              </v-list-item-group>
            </v-list>
          </v-card>
        </v-col>
      </v-row>

    </v-container>
  </div>
</template>


<script>
export default {
  name: 'Profile',
  data: () => ({
    tags: [
      'Work',
      'Home Improvement',
      'Vacation',
      'Food',
      'Drawers',
      'Shopping',
      'Art',
      'Tech',
      'Creative Writing',
    ],
    hasSaved: false,
    isEditing: null,
    model: null,
    states: [
      { name: 'Florida', abbr: 'FL', id: 1 },
      { name: 'Georgia', abbr: 'GA', id: 2 },
      { name: 'Nebraska', abbr: 'NE', id: 3 },
      { name: 'California', abbr: 'CA', id: 4 },
      { name: 'New York', abbr: 'NY', id: 5 },
    ],
  }),
  methods: {
    customFilter (item, queryText) {
      const textOne = item.name.toLowerCase()
      const textTwo = item.abbr.toLowerCase()
      const searchText = queryText.toLowerCase()

      return textOne.indexOf(searchText) > -1 ||
        textTwo.indexOf(searchText) > -1
    },
    save () {
      this.isEditing = !this.isEditing
      this.hasSaved = true
    },
  },
}
</script>
