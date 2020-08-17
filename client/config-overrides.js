const { addBabelPlugin, override, fixBabelImports, addWebpackAlias } = require('customize-cra');
const path = require('path');

module.exports = override(
  addBabelPlugin('react-hot-loader/babel'),
  fixBabelImports('antd', {
    libraryDirectory: 'es',
    style: true,
  }),
  addWebpackAlias({
    '@styleguide': path.resolve(__dirname, 'src/styleguide/components'),
    '@': path.resolve(__dirname, 'src'),
    'react-dom': process.env.NODE_ENV === 'production' ? 'react-dom' : '@hot-loader/react-dom',
  }),
);
