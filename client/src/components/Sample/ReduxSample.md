ReduxSample example:

```js
import StyleContainer from '../../styleguide/components/StyleContainer.tsx';
import StoreProvider from '../../styleguide/components/StoreProvider.tsx';

<StoreProvider>
  <StyleContainer style={{ height: 300 }} direction="vertical">
    <ReduxSample />
  </StyleContainer>
</StoreProvider>;
```
