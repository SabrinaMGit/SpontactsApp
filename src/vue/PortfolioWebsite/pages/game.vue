<template>
  <grid-images :images="images"></grid-images>
</template>

<script>
import gridImages from '~/components/GridImages.vue';

export default {
  name: 'game',
  components: {
    gridImages
  },
  data: () => ({
    images: [
      { name: '3ds_Max' },
      { name: 'Autodesk' },
      { name: 'illustrator' },
      { name: 'maya' },
      { name: 'photoshop_icon' },
      { name: 'unrealEngine' },
      { name: 'ZBrush' },
      { name: 'aftereffects' },
    ],
  }),
}
</script>
