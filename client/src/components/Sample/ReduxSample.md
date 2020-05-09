ReduxSample example:

```js
import StyleContainer from '../../styleguide/components/StyleContainer.jsx';
import StoreProvider from '../../styleguide/components/StoreProvider.jsx';

<StoreProvider>
  <StyleContainer style={{ height: 300 }} direction="vertical">
    <ReduxSample />
  </StyleContainer>
</StoreProvider>;
```
