ReduxSample example:

```js
import StyleContainer from '@styleguide/StyleContainer.tsx';
import StoreProvider from '@styleguide/StoreProvider.tsx';

<StoreProvider>
  <StyleContainer style={{ height: 300 }} direction="vertical">
    <ReduxSample />
  </StyleContainer>
</StoreProvider>;
```
