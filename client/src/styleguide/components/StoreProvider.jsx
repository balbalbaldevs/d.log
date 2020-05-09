import React from 'react';
import { Provider } from 'react-redux';
import configureStore from '../../configureStore';

const store = configureStore();

const StoreProvider = (props) => <Provider {...props} store={store} />;

export default StoreProvider;
