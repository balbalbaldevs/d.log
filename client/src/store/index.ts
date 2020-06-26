import { configureStore, getDefaultMiddleware } from '@reduxjs/toolkit';
import loggerMiddleware from '../middlewares/logger';
import monitorReducerEnhancer from '../enhancers/monitorReducers';
import { AppState } from './store.types';
import rootReducer from './reducers';

export const configureAppStore = (preloadedState = {}) => {
  const store = configureStore({
    reducer: rootReducer,
    preloadedState,
    middleware: [loggerMiddleware, ...getDefaultMiddleware<AppState>()],
    enhancers: [monitorReducerEnhancer],
  });

  if (process.env.NODE_ENV === 'development' && module.hot) {
    module.hot.accept('./reducers.ts', () => {
      const newRootReducer = require('./reducers.ts').default;
      store.replaceReducer(newRootReducer);
    });
  }

  return store;
};

export type AppDispatch = ReturnType<typeof configureAppStore>['dispatch'];
