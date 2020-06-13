import { configureStore, getDefaultMiddleware } from '@reduxjs/toolkit';
import rootReducer from './store';
import loggerMiddleware from './middlewares/logger';
import monitorReducerEnhancer from './enhancers/monitorReducers';
import { AppState } from './store/store.types';

export type AppDispatch = ReturnType<typeof configureAppStore>['dispatch'];

const configureAppStore = (preloadedState = {}) => {
  const store = configureStore({
    reducer: rootReducer,
    preloadedState,
    middleware: [loggerMiddleware, ...getDefaultMiddleware<AppState>()],
    enhancers: [monitorReducerEnhancer],
  });

  if (process.env.NODE_ENV === 'development' && module.hot) {
    module.hot.accept('./store', () => {
      const newRootReducer = require('./store').default;
      store.replaceReducer(newRootReducer);
    });
  }

  return store;
};

export default configureAppStore;
