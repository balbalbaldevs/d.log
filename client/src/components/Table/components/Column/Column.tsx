import React from 'react';
import { Table as AntdTable } from 'antd';
import { ColumnProps } from './Column.types';

function Column<T extends object = any>({ children }: ColumnProps<T>) {
  return <AntdTable.Column>
    {children}
  </AntdTable.Column>;
}

export default Column;
