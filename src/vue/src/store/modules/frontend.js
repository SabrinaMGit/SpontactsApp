// Imports
import {
  make,
} from 'vuex-pathify'

const state = {
  drawer: false,
  items: [
    {
      icon: 'mdi-card-account-details',
      text: 'Mein Profil',
      to: { name: 'Profile' },
    },
    {
      icon: 'mdi-account-supervisor-circle-outline',
      text: 'Meine Freunde',
      to: { name: 'Profile' },
    },
    {
      icon: 'mdi-human',
      text: 'Meine Aktivitäten',
      to: { name: 'Dashboard' },
    },
    {
      icon: 'mdi-certificate',
      text: 'Spontacts Premium',
      to: { name: 'Newactiv' },
    },
    {
      icon: 'mdi-tune',
      text: 'Kontoeinstellungen',
      to: { name: 'Profile' },
    },
    {
      icon: 'mdi-information',
      text: 'Hilfe',
      to: { name: 'Profile' },
    },
    {
      icon: 'mdi-web',
      text: 'English',
      to: { name: 'Profile' },
    },
    {
      icon: 'mdi-exit-to-app',
      text: 'Abmelden',
      to: { name: 'Profile' },
    },
  ],
}

const mutations = make.mutations(state)

const actions = {}

const getters = {}

export default {
  namespaced: true,
  state,
  mutations,
  actions,
  getters,
}
