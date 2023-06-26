package com.falcon.gymlog_yaka

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils.replace
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext



// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ScheduleViewFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ScheduleViewFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_schedule_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val addBtn:FloatingActionButton = view.findViewById(R.id.fab)

        addBtn.setOnClickListener{
            childFragmentManager.beginTransaction().apply {
                replace(R.id.frameLayoutSchedule, AddScheduleFragment())
                commit()
            }
        }

        GlobalScope.launch(Dispatchers.IO) {
            val db = DBhelper.getDatabase(requireContext())
            val scheduleDao = db.scheduleDao()
            val schedules: List<WorkoutListtableEntity> = scheduleDao.getAllSchedules()

            withContext(Dispatchers.Main) {
                val recyclerView: RecyclerView = view.findViewById(R.id.SchduleRecyclerView)
                val data: List<String?> = schedules.map { it.workout_list_name }
                val adapter = recyclerSchduleViewAdapter(data)
                recyclerView.adapter = adapter
                recyclerView.layoutManager = LinearLayoutManager(requireContext())
                Log.e("Tag bravo : ", "recyclerView ok ${data}")
            }
        }

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ScheduleViewFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ScheduleViewFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}