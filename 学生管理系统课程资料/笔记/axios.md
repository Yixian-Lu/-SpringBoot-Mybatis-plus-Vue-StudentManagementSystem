####  安装axios

```bash
npm i axios
```

#### 基本使用

```js
import axios from 'axios'

axios.get('http://localhost:8000/students').then(
	response => {
		console.log(response.data);
	},
	error =>{
		console.log(error.massage);
	}
)
```

