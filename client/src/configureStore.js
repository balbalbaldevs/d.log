import { configureStore, getDefaultMiddleware } from '@reduxjs/toolkit';
import rootReducer from './redux';
import loggerMiddleware from './middlewares/logger';
import monitorReducerEnhancer from './enhancers/monitorReducers';

export default function configureAppStore(preloadedState) {
  const store = configureStore({
    reducer: rootReducer,
    preloadedState,
    middleware: [loggerMiddleware, ...getDefaultMiddleware()],
    enhancers: [monitorReducerEnhancer],
  });

  if (process.env.NODE_ENV === 'development' && module.hot) {
    module.hot.accept('./redux', () => {
      // eslint-disable-next-line global-require
      const newRootReducer = require('./redux').default;
      store.replaceReducer(newRootReducer);
    });
  }

  return store;
}
