import React from 'react';
import { Provider } from 'react-redux';
import { configureAppStore as configureStore } from '@/store';

const store = configureStore();

const StoreProvider: React.FC = ({ ...rest }) => <Provider {...rest} store={store} />;

export default StoreProvider;
