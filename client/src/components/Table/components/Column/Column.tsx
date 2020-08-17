import { Table as AntdTable } from 'antd';
import React from 'react';

import { ColumnProps } from './Column.types';

function Column<T extends Record<string, unknown>>({ children }: ColumnProps<T>) {
  return <AntdTable.Column>{children}</AntdTable.Column>;
}

export default Column;
