<template>
  <grid-images :images="images"></grid-images>
</template>

<script>
import gridImages from '~/components/GridImages.vue';

export default {
  name: 'deployment',
  components: {
    gridImages
  },
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
