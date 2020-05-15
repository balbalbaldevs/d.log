module.exports = {
  title: 'd.log UI guide',
  components: 'src/components/**/*.jsx',
  pagePerSection: true,
  sections: [
    {
      name: 'Introduction',
      content: 'src/styleguide/docs/introduction.md',
    },
    {
      name: 'Components',
      components: 'src/components/**/*.jsx',
      ignore: 'src/components/Sample/*.jsx',
      exampleMode: 'expand',
      usageMode: 'expand',
      sectionDepth: 0,
    },
    {
      name: 'Sample',
      components: 'src/components/Sample/*.jsx',
      exampleMode: 'expand',
      usageMode: 'expand',
      sectionDepth: 0,
    },
  ],
};
