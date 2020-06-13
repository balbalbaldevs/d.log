import { combineReducers, Reducer } from '@reduxjs/toolkit';
import reduxSampleReducer from './ReduxSample/ReduxSample.reducers';

const rootReducer: Reducer = combineReducers({
  sample: reduxSampleReducer,
});

export default rootReducer;
