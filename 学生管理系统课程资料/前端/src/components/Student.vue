<template>
  <tr>
    <td v-show="!is_edit">{{ student.number }}</td>
      <td v-show="!is_edit">{{ student.name }}</td>
      <td v-show="!is_edit">{{ student.age }}</td>
      <td v-show="!is_edit">{{ student.chi }}</td>
      <td v-show="!is_edit">{{ student.math }}</td>
      <td v-show="!is_edit">{{ student.eng }}</td>
      <td v-show="!is_edit">
          <el-button type="primary" @click="modify">修改</el-button>
      </td>
      <td v-show="!is_edit">
        尽量不要直接写delete，方法名可能chong tu
          <el-button type="danger" @click="deleteStudent">删除</el-button>
      </td>
<!--弹出修改输入框-->

       <td v-show="is_edit"><input  class="w-50" type="text" v-model="student.number"/></td>
      <td v-show="is_edit"><input  class="w-50" type="text" v-model="student.name"/></td>
      <td v-show="is_edit"><input   class="w-50" type="text" v-model.number="student.age"/></td>
<!--    v-model.number 解析成数字-->
      <td v-show="is_edit"><input  class="w-50" type="text" v-model.number="student.chi"/></td>
      <td v-show="is_edit"><input   class="w-50" type="text" v-model.number="student.math"/></td>
      <td v-show="is_edit"><input  class="w-50" type="text" v-model.number="student.eng"/></td>
      <td v-show="is_edit">
          <el-button type="primary" @click="save">保存</el-button>
      </td>
      <td v-show="is_edit">
          <el-button type="danger">删除</el-button>
      </td>
    </tr>
</template>

<script>
import axios from 'axios'
export default {
  // student组件拿到APP传过来的数据
    props:["student"],
    data() {
        return {
          //  一开始没有处于编辑状态
            is_edit:false
        }
    },
    methods:{
        modify(){
            this.is_edit=true;
        },
        save(){
            axios({
              //数据发送到后端
                url: "http://localhost:8080/update",
                method: "POST",
                data:this.student
            })
            this.is_edit=false;
        },
        deleteStudent(){
            axios({
                url: "http://localhost:8080/delete",
                method: "POST",
                data:this.student
            })
          //刷新页面
            location.reload(); 
        }
    }
}
</script>

<style>
    
</style>