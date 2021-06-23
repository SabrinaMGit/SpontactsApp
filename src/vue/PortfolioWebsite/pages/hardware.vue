<template>
  <grid-images :images="images"></grid-images>
</template>

<script>
import gridImages from '~/components/GridImages.vue';

export default {
  name: 'hardware',
  components: {
    gridImages
  },
  data: () => ({
    images: [
      { name: '3ds_Max' },
      { name: 'android' },
      { name: 'arduino' },
      { name: 'arduino_icon' },
      { name: 'Autodesk' },
      { name: 'bootstrap' },
      { name: 'docker' },
      { name: 'git' },
      { name: 'illustrator' },
      { name: 'javaLogo' },
      { name: 'maya' },
      { name: 'nodejs' },
      { name: 'photoshop_icon' },
      { name: 'postgresql' },
      { name: 'raspberry_pi' },
      { name: 'sketch' },
      { name: 'ssh' },
      { name: 'udemy' },
      { name: 'unrealEngine' },
      { name: 'vue' },
      { name: 'ZBrush' },
      { name: 'invision' },
      { name: 'jenkins' },
      { name: 'xcode' },
    ],
  }),
}
</script>
