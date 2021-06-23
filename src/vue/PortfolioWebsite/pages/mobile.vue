<template>
  <grid-images :images="images"></grid-images>
</template>

<script>
import gridImages from '~/components/GridImages.vue';

export default {
  name: 'mobile',
  components: {
    gridImages
  },
  data: () => ({
    images: [
      { name: 'android' },
      { name: 'sketch' },
      { name: 'invision' },
      { name: 'xcode' },
      { name: 'xml' },
      { name: 'json' },
    ],
  }),
}
</script>
