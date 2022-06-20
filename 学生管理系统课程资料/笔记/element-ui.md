#### 安装element-ui包,在终端执行以下命令

```bash
npm i element-ui
```

#### 在main.js中写入以下内容

```js
import Vue from 'vue';
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import App from './App.vue';

Vue.use(ElementUI);

new Vue({
  el: '#app',
  render: h => h(App)
});
```

