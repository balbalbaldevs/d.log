const { override, fixBabelImports, addWebpackAlias } = require('customize-cra');
const path = require('path');

module.exports = override(
  fixBabelImports('antd', {
    libraryDirectory: 'es',
    style: true,
  }),
  addWebpackAlias({
    ['@styleguide']: path.resolve(__dirname, 'src/styleguide/components'),
    ['@']: path.resolve(__dirname, 'src'),
  }),
);
