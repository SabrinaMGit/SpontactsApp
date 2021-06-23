<template>
  <grid-images :images="images"></grid-images>
</template>

<script>
import gridImages from '~/components/GridImages.vue';

export default {
  name: 'languages',
  components: {
    gridImages
  },
  data: () => ({
    images: [
      { name: 'javaLogo' },
      { name: 'nodejs' },
      { name: 'swift' },
      { name: 'c' },
      { name: 'python' },
      { name: 'bash' },
    ],
  }),
}
</script>
