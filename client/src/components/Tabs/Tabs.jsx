import React from 'react';
import { Tabs as AntTabs } from 'antd';
import { oneOfType } from 'prop-types';
import classNames from 'classnames';
import { string, number, func } from 'prop-types';
import Tab from './components/Tab';
import Panel from './components/Panel';
import './Tabs.scss';

const Tabs = ({ defaultActiveKey, onChange, children, className }) => {
  console.log('tabs children', children);
  const handleChange = (key) => {
    console.log('tab onChnage', key)
    if (onChange) {
      onChange(key)
    }
  };
  return <AntTabs
    defaultActiveKey={defaultActiveKey}
    type="card"
    onChange={handleChange}
    className={classNames('tabs', className)}
  >
    {children}
  </AntTabs>
};

Tabs.TabList = AntTabs.TabPane;
Tabs.Tab = Tab;
Tabs.Panel = Panel;
Tabs.displayName = 'Tabs';

Tabs.propTypes = {
  defaultActiveKey: oneOfType(string, number),
  onChange: func,
  className: string
};

export default Tabs;