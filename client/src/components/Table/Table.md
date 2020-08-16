---
상세한 `Table` 컴포넌트 props 리스트는 (여기)[https://ant.design/components/table/]에서 확인.

----

### 기본 예시:

```js
import StyleContainer from '../../styleguide/components/StyleContainer';

const data = [
  {
    id: '1',
    name: 'John Brown',
    age: 32,
    address: 'New York No. 1 Lake Park',
    tags: ['nice', 'developer'],
  },
  {
    id: '2',
    name: 'Jim Green',
    age: 42,
    address: 'London No. 1 Lake Park',
    tags: ['loser'],
  },
  {
    id: '3',
    name: 'Joe Black',
    age: 32,
    address: 'Sidney No. 1 Lake Park',
    tags: ['cool', 'teacher'],
  },
  {
    id: '4',
    name: 'John Brown',
    age: 32,
    address: 'New York No. 1 Lake Park',
    tags: ['nice', 'developer'],
  },
  {
    id: '5',
    name: 'Jim Green',
    age: 42,
    address: 'London No. 1 Lake Park',
    tags: ['loser'],
  },
  {
    id: '6',
    name: 'Joe Black',
    age: 32,
    address: 'Sidney No. 1 Lake Park',
    tags: ['cool', 'teacher'],
  },
  {
    id: '7',
    name: 'Joe Black',
    age: 32,
    address: 'Sidney No. 1 Lake Park',
    tags: ['cool', 'teacher'],
  },
  {
    id: '8',
    name: 'Joe Black',
    age: 32,
    address: 'Sidney No. 1 Lake Park',
    tags: ['cool', 'teacher'],
  },
];

const columns = [
  {
    title: 'Name',
    dataIndex: 'name',
    render: text => <a href="#/Components/Table">{text}</a>,
  },
  {
    title: 'Age',
    dataIndex: 'age',
  },
  {
    title: 'Address',
    dataIndex: 'address',
  },
];

<StyleContainer>
  <Table 
    rowKey="id" 
    data={data} 
    columns={columns}
    scrollY={300}
    scrollX={500}
    style={{ width: 250 }} 
  />
</StyleContainer>
```

테이블 컴럼을 JSX 안에서 사용하는 예시:

```js
const data = [
  {
    id: '1',
    name: 'John Brown',
    age: 32,
    address: 'New York No. 1 Lake Park',
    tags: ['nice', 'developer'],
  },
  {
    id: '2',
    name: 'Jim Green',
    age: 42,
    address: 'London No. 1 Lake Park',
    tags: ['loser'],
  },
  {
    id: '3',
    name: 'Joe Black',
    age: 32,
    address: 'Sidney No. 1 Lake Park',
    tags: ['cool', 'teacher'],
  },
];

<>
<Table data={data} rowKey="id" border={true}>
  <Table.Column dataIndex="name" title="Name" />
  <Table.Column dataIndex="age" title="Age" />
  <Table.Column dataIndex="address" title="Address" />
</Table>
</>
```