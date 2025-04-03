<template>

  <div class="min-h-screen bg-gray-50">

    <!-- 导航栏 -->

    <nav class="fixed top-0 left-0 right-0 h-16 bg-white shadow-sm z-50">

      <div class="max-w-7xl mx-auto px-4 flex items-center justify-between h-full">

        <div class="flex items-center space-x-2">

          <el-icon class="text-2xl">

            <Promotion />

          </el-icon>

          <span class="text-xl font-medium">Zyyo</span>

        </div>

        <div class="flex items-center space-x-6">

          <el-menu mode="horizontal" :ellipsis="false" class="border-none">

            <el-menu-item index="1">标签</el-menu-item>

            <el-menu-item index="2">分类</el-menu-item>

            <el-menu-item index="3">页面</el-menu-item>

          </el-menu>

        </div>

        <div class="flex items-center space-x-4">

          <el-button type="text" class="!rounded-button">

            <el-icon>

              <Bell />

            </el-icon>

          </el-button>

          <el-button type="text" class="!rounded-button">

            <el-icon>

              <Search />

            </el-icon>

          </el-button>

          <el-avatar :size="32" :src="avatarUrl" />

        </div>

      </div>

    </nav>

    <!-- 主要内容区域 -->

    <main class="pt-20 pb-8 max-w-7xl mx-auto px-4">

      <div class="grid grid-cols-12 gap-6">

        <!-- 左侧个人信息卡片 -->

        <div class="col-span-4">

          <div
            class="rounded-3xl bg-gradient-to-br from-blue-400 to-blue-600 bg-opacity-50 p-6 relative overflow-hidden">

            <div class="flex flex-col items-center relative z-0">

              <div class="relative w-full h-32" @mouseenter="showProfile = true" @mouseleave="showProfile = false">

                <div class="mb-4" v-if="!showProfile">

                  <el-avatar :size="80" :src="avatarUrl" class="cursor-pointer" />

                  <h2 class="text-xl font-medium">{{ userInfo.name }}</h2>

                  <p class="text-sm opacity-90">{{ userInfo.description }}</p>

                </div>

                <div v-if="showProfile"
                  class="absolute top-0 left-0 right-0 bottom-0 transition-opacity duration-300 flex items-center justify-center p-6"
                  @mouseenter.stop @mouseleave.stop>

                  <p class="text-sm leading-relaxed">

                    {{ userInfo.introduction }}

                  </p>

                </div>

              </div>

              <div class="mt-4 flex justify-between items-center relative z-20">

                <div class="flex space-x-2">

                  <el-button type="primary"
                    class="!rounded-button bg-white/20 hover:bg-white/30 border-none w-16 text-sm font-medium tracking-wide uppercase transition-all duration-300 transform hover:scale-105 hover:rotate-180">

                    about

                  </el-button>

                  <el-button type="primary"
                    class="!rounded-button bg-white/20 hover:bg-white/30 border-none w-16 text-sm font-medium tracking-wide uppercase transition-all duration-300 transform hover:scale-105 hover:rotate-180">

                    <el-icon>

                      <Message />

                    </el-icon>

                  </el-button>

                  <el-button type="primary"
                    class="!rounded-button bg-white/20 hover:bg-white/30 border-none w-16 text-sm font-medium tracking-wide uppercase transition-all duration-300 transform hover:scale-105 hover:rotate-180">

                    <el-icon>

                      <Bell />

                    </el-icon>

                  </el-button>

                  <el-button type="primary"
                    class="!rounded-button bg-white/20 hover:bg-white/30 border-none w-16 text-sm font-medium tracking-wide uppercase transition-all duration-300 transform hover:scale-105 hover:rotate-180">

                    <el-icon>

                      <Link />

                    </el-icon>

                  </el-button>

                </div>

              </div>

            </div>

          </div>

          <!-- 欢迎区域 -->

          <div class="mt-6 bg-white rounded-xl p-6">

            <h3 class="text-lg font-medium mb-4">欢迎光临</h3>

            <div class="grid grid-cols-4 gap-4">

              <div v-for="icon in icons" :key="icon.name" class="flex flex-col items-center">

                <el-icon class="text-2xl text-gray-600">

                  <component :is="icon.component" />

                </el-icon>

                <span class="text-xs mt-2 text-gray-600">{{ icon.name }}</span>

              </div>

            </div>

          </div>

          <!-- 统计信息 -->

          <div class="mt-6 bg-white rounded-xl p-6">

            <div class="grid grid-cols-2 gap-4">

              <div class="text-center">

                <div class="text-blue-500 font-medium">成立</div>

                <div class="text-2xl font-bold text-gray-800">{{ statistics.daysEstablished }}天</div>

              </div>

              <div class="text-center">

                <div class="text-blue-500 font-medium">文章</div>

                <div class="text-2xl font-bold text-gray-800">{{ statistics.articlesCount }}篇</div>

              </div>

              <div class="text-center">

                <div class="text-blue-500 font-medium">评论</div>

                <div class="text-2xl font-bold text-gray-800">{{ statistics.commentsCount }}条</div>

              </div>

              <div class="text-center">

                <div class="text-blue-500 font-medium">标签</div>

                <div class="text-2xl font-bold text-gray-800">{{ statistics.tagsCount }}个</div>

              </div>

            </div>

          </div>

        </div>

        <!-- 右侧内容区域 -->

        <div class="col-span-8">

          <!-- 图片展示区 -->

          <div class="relative h-48 mb-6">

            <div class="absolute right-0 top-0 flex -space-x-4">

              <img :src="imageUrls[0]"
                class="w-40 h-40 rounded-lg shadow-lg transform rotate-[-15deg] transition-all duration-300 hover:rotate-0 hover:scale-110 hover:z-10" />

              <img :src="imageUrls[1]"
                class="w-40 h-40 rounded-lg shadow-lg transform rotate-[-5deg] transition-all duration-300 hover:rotate-0 hover:scale-110 hover:z-10" />

              <img :src="imageUrls[2]"
                class="w-40 h-40 rounded-lg shadow-lg transform rotate-[5deg] transition-all duration-300 hover:rotate-0 hover:scale-110 hover:z-10" />

            </div>

          </div>

          <!-- 文章列表 -->

          <div class="grid grid-cols-1 gap-6">

            <div v-for="article in articles" :key="article.id"
              class="bg-white rounded-xl overflow-hidden shadow-sm hover:shadow-md transition-shadow">

              <img :src="article.image" class="w-full h-48 object-cover" />

              <div class="p-6">

                <h3 class="text-lg font-medium mb-2">{{ article.title }}</h3>

                <div class="text-sm text-gray-500">{{ article.date }}</div>

              </div>

            </div>

          </div>

        </div>

      </div>

    </main>

  </div>

</template>

<script lang="ts" setup>

import { ref, onMounted } from 'vue';

import axios from 'axios';

import { Bell, Search, Message, Link, Promotion } from '@element-plus/icons-vue';



const avatarUrl = ref('');

const imageUrls = ref<string[]>([]);

const icons = ref<any[]>([]);

const articles = ref<any[]>([]);

const userInfo = ref<any>({});

const statistics = ref<any>({});

const showProfile = ref(false);



onMounted(async () => {

  try {

    const response = await axios.get('/api/data');

    const data = response.data;



    avatarUrl.value = data.avatarUrl;

    imageUrls.value = data.imageUrls;

    icons.value = data.icons;

    articles.value = data.articles;

    userInfo.value = data.userInfo;

    statistics.value = data.statistics;

  } catch (error) {

    console.error('数据获取失败:', error);

  }

});

</script>

<style scoped>
.el-menu--horizontal {

  border-bottom: none !important;

}



.el-menu-item {

  font-size: 14px;

  font-weight: 500;

}



:deep(.el-button) {

  height: 36px;

  padding: 8px 24px;

  display: inline-flex;

  align-items: center;

  justify-content: center;

  font-weight: 500;

}



:deep(.el-input__wrapper) {

  background-color: #f3f4f6;

  border: none;

  box-shadow: none !important;

}



:deep(.el-input__inner) {

  height: 36px;

}
</style>
