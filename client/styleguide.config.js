const path = require('path');
const jsParser = require('react-docgen');
const tsParser = require('react-docgen-typescript');

module.exports = {
  title: 'd.log UI guide',
  components: 'src/components/**/*.tsx',
  skipComponentsWithoutExample: true,
  pagePerSection: true,
  moduleAliases: {
    '@styleguide': path.resolve(__dirname, 'src/styleguide/components'),
    '@': path.resolve(__dirname, 'src'),
  },
  sections: [
    {
      name: 'Introduction',
      content: 'src/styleguide/docs/introduction.md',
    },
    {
      name: 'Components',
      components: 'src/components/*/*.tsx',
      ignore: 'src/components/Sample/*.tsx',
      exampleMode: 'expand',
      usageMode: 'expand',
      sectionDepth: 0,
    },
    {
      name: 'Sample',
      components: 'src/components/Sample/*.tsx',
      exampleMode: 'expand',
      usageMode: 'expand',
      sectionDepth: 0,
    },
  ],
  resolver: jsParser.resolver.findAllComponentDefinitions,
  propsParser: tsParser.withCustomConfig('./tsconfig.json', {
    propFilter: (prop) => prop.parent == null ? true : !prop.parent.fileName.includes('node_modules')
  }).parse,
  webpackConfig: require('react-scripts/config/webpack.config'),
};
