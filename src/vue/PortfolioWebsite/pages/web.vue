<template>
  <grid-images :images="images"></grid-images>
</template>

<script>
import gridImages from '~/components/GridImages.vue';

export default {
  name: 'web',
  components: {
    gridImages
  },
  data: () => ({
    images: [
      { name: 'bootstrap' },
      { name: 'nodejs' },
      { name: 'sketch' },
      { name: 'vue' },
      { name: 'invision' },
      { name: 'react' },
      { name: 'angular' },
      { name: 'html' },
      { name: 'css' },
    ],
  }),
}
</script>
