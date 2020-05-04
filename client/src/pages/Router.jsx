import React from 'react';
import { BrowserRouter, Switch, Route, Redirect } from 'react-router-dom';

import { Home } from '.';

export const PAGE_URL = {
  ROOT: '/',
  HOME: '/home',
  LOGIN: '/login',
  MY_PAGE: '/my/page',
};

const ROUTES = [{ path: PAGE_URL.HOME, exact: true, component: Home }];

const Router = () => (
  <BrowserRouter>
    <Switch>
      <Redirect exact path={PAGE_URL.ROOT} to={PAGE_URL.HOME} />
      {ROUTES.map(route => (
        <Route {...route} key={route.path} />
      ))}
    </Switch>
  </BrowserRouter>
);

export default Router;
