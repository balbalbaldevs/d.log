import React from 'react';
import { BrowserRouter, Switch, Route, Redirect } from 'react-router-dom';

import Home from './Home';

export const PAGE_URL = {
  HOME: '/home',
  LOGIN: '/login',
  MY_PAGE: '/my/page',
};

const Router = () => (
  <BrowserRouter>
    <Switch>
      <Redirect exact path={'/'} to={PAGE_URL.HOME} />
      <Route exact path={PAGE_URL.HOME} component={Home} />
    </Switch>
  </BrowserRouter>
);

export default Router;
